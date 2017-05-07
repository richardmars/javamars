package io.github.richardmars.exam.thoughtworks;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import io.github.richardmars.exam.thoughtworks.DataLogicException;

public class SnapShotUtils {
	
	/**
	 * 构建SnapShot的Map集合
	 * @param historyData
	 * @return
	 * @throws Exception
	 */
	public static Map<String, SnapShot> makeUpSnapShotMap(String historyData) throws Exception{
		Map<String, SnapShot> snapShotMap = new HashMap<>();
		
		int lineNum = 0;	// 每一个SnapShot的行号
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		String[] datas = historyData.split("\r\n");
		
		SnapShot snapShot = null;
		SnapShot lastSnapShot = null;
		for (String data : datas) {
			if (data.equals("")) {	// 空行清零行号并新建立对象 
				lineNum = 0;
				if (snapShot != null) {
					snapShotMap.put(snapShot.getId(), snapShot);
				}
				continue;
			}
			
			if (lineNum == 0) {
				snapShot = new SnapShot();
				snapShot.setId(data);
				snapShot.setLastSnapShot(lastSnapShot);
				lastSnapShot = snapShot;
			}
			else if (lineNum == 1) {
				snapShot.setDate(sdf.parse(data));
			}
			else {
				String[] animalPosInfos = data.split("\\s");
				AnimalPostion animalPostion = new AnimalPostion();
				
				if (animalPosInfos.length == 3) {
					animalPostion.setFirstAppear(true);
					animalPostion.setAnimalId(animalPosInfos[0]);
					animalPostion.setCurrentLocationX(Integer.parseInt(animalPosInfos[1]));
					animalPostion.setCurrentLocationY(Integer.parseInt(animalPosInfos[2]));
				}
				else if (animalPosInfos.length == 5) {
					animalPostion.setFirstAppear(false);
					animalPostion.setAnimalId(animalPosInfos[0]);
					animalPostion.setLastLocationX(Integer.parseInt(animalPosInfos[1]));
					animalPostion.setLastLocationY(Integer.parseInt(animalPosInfos[2]));
					animalPostion.setChangeX(Integer.parseInt(animalPosInfos[3]));
					animalPostion.setChangeY(Integer.parseInt(animalPosInfos[4]));
					
					// 校验数据逻辑的正确性
					// 1.位置错误
					AnimalPostion lastAnimalPosition = lastAppearPostion(animalPostion.getAnimalId(), snapShot);
					if (lastAnimalPosition.getCurrentLocationX() != animalPostion.getLastLocationX() ||
						lastAnimalPosition.getCurrentLocationY() != animalPostion.getLastLocationY()) {
						throw new DataLogicException(snapShot.getId());
					}
					// 2.时间错误
					if (!snapShot.getLastSnapShot().getDate().before(snapShot.getDate())) {
						throw new DataLogicException(snapShot.getId());
					}
				}
				else {
					// 其他格式错误
					throw new Exception();
				}
				
				snapShot.getAnimalPostions().add(animalPostion);
			}
			
			lineNum++;
			
			// 到达了字符串的最后一行
			if (data.equals(datas[datas.length - 1]) && data != null) {
				if (snapShotMap.get(snapShot.getId()) == null && snapShot != null) {
					snapShotMap.put(snapShot.getId(), snapShot);
				}
			}
		}
		
		return snapShotMap;
	}
	
	/**
	 * 寻找一个动物上一次出现的快照
	 * @param animalId
	 */
	private static AnimalPostion lastAppearPostion(String animalId, SnapShot snapShot) {
		for (AnimalPostion animalPostion : snapShot.getLastSnapShot().getAnimalPostions() ) {
			if (animalPostion.getAnimalId().equals(animalId)) {
				return animalPostion;
			}
		}
		return null;
	}
	
	public static String getSnapShot(String historyData, String id) {
		Map<String, SnapShot> snapShotMap ;
		try {
			snapShotMap = makeUpSnapShotMap(historyData);
			SnapShot snapShot = snapShotMap.get(id);
			if (snapShot == null) {
				return "Snapshot with " + id + " is not exist.";
			}
			else {
				return toResultString(snapShot);
			}
		} catch (Exception e) {
			if (e instanceof DataLogicException) {
				return e.getMessage();
			}
			else {
				return "Invalid format.";
			}
		}
	}
	
	public static String toResultString(SnapShot snapShot) {
		String[] resultArray = new String[snapShot.getAnimalPostions().size()];
		int i = 0;
		for (AnimalPostion animalPostion : snapShot.getAnimalPostions()) {
			
			String positionInfo = animalPostion.getAnimalId() + " " 
									+ animalPostion.getCurrentLocationX() + " " 
									+ animalPostion.getCurrentLocationY(); 
			resultArray[i] = positionInfo;
			i++;
		}
		Arrays.sort(resultArray, String.CASE_INSENSITIVE_ORDER);
		StringBuffer sb = new StringBuffer();
		for (String result : resultArray) {
			sb.append(result).append("\n");
		}
		return sb.toString();
	}
}

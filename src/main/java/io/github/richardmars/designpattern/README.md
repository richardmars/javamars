# Structural pattern
## Facade 和 Proxy 的区别：

Facade Pattern（门面模式）：门面模式要求一个子系统的外部与其内部的通信必须通过一个统一的门面(Facade)对象进行。门面模式提供一个高层次的接口，使得子系统更易于使用。

Proxy Pattern（代理模式）：为其他对象创建一个代理，并以控制对这个对象的访问。将代理对象作为真实对象的替身，一方面能够通过（引用）缓存真实对象提高性能，另一方能够在代理对象中添加或删除一定的真实对象功能。

## Prototype

通过clone的方式来创建对象，从而提高性能。

# Behaviour pattern
## NullObject

通过不作为的NullObject来执行程序，保证程序统一性，减少null check。

## Template

对象执行操作的顺序固定（有模板），只是每个步骤的具体工作不同。

## Visitor

目标对象类的执行逻辑由visitor决定，可以动态变化。

## Composite entity

综合对象属性的变化会自动更新到依赖对象。
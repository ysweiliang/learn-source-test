package cn.yuans.test.designmode.strategyfactory;

/**
 * 抽象工厂
 *
 * @author yuans
 * @create 2021-04-22-15:04
 */
public abstract class StrategyFactory<T> {
    abstract RewardStrategy createStrategy(Class<T> c);
}

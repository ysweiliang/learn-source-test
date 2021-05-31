package cn.yuans.test.designmode.strategyfactory;

/**
 * 具体工厂创建具体的策略
 *
 * @author yuans
 * @create 2021-04-22-15:05
 */
public class FactorRewardStrategyFactory extends StrategyFactory {
    @Override
    RewardStrategy createStrategy(Class c) {
        RewardStrategy product = null;
        try {
            product = (RewardStrategy) Class.forName(c.getName()).
                    newInstance();
        } catch (Exception e) {
        }
        return product;
    }
}

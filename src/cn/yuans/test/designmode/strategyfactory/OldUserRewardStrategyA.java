package cn.yuans.test.designmode.strategyfactory;

/**
 * @author yuans
 * @create 2021-04-22-15:03
 */
public class OldUserRewardStrategyA extends RewardStrategy {
    @Override
    public int reward(long userId) {
        return 2;
    }
}

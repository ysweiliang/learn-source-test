package cn.yuans.test.designmode.strategyfactory;

/**
 * @author yuans
 * @create 2021-04-22-15:05
 */
public class RewardContext {
    private RewardStrategy strategy;

    public RewardContext(RewardStrategy strategy) {
        this.strategy = strategy;
    }

    public void doStrategy(long userId) {
        int rewardMoney = strategy.reward(userId);
        strategy.insertRewardAndSettlement(userId, rewardMoney);
    }
}

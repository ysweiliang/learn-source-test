package cn.yuans.test.designmode.strategyfactory;

/**
 * @author yuans
 * @create 2021-04-22-15:01
 */
public abstract class RewardStrategy {
    public abstract int reward(long userId);
    public void insertRewardAndSettlement(long userId, int reward) {
        //insertReward(userId, rewardMoney);
        //settlement(userId);
    }
    // 更新用户信息以及结算
}

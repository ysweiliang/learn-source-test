package cn.yuans.test.designmode.strategyfactory;

/**
 * @author yuans
 * @create 2021-04-22-15:08
 */
public class InviteRewardImpl {
    // 返奖主流程
    public void sendReward(long userId) {
        FactorRewardStrategyFactory strategyFactory = new FactorRewardStrategyFactory(); // 创建工厂
        Invitee invitee = getInviteeByUserId(userId);
        // 根据用户 id 查询用户信息
       /* if (invitee.userType == UserTypeEnum.NEW_USER) { // 新用户返奖策略
            NewUserBasicReward newUserBasicReward = (NewUserBasicReward)
                    strategyFactory.createStrategy(NewUserBasicReward.class);
            RewardContext rewardContext = new RewardContext(newUserBasicReward);
            rewardContext.doStrategy(userId); // 执行返奖策略
        }
        if (invitee.userType == UserTypeEnum.OLD_USER) {
        } // 老用户返奖策略，*/
    }

    private Invitee getInviteeByUserId(long userId) {
        return new Invitee();
    }
}

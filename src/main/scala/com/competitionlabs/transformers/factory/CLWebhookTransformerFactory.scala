/***
  *  Copyright (C) Competition Labs Ltd - All Rights Reserved
  *  Unauthorized copying of this file, via any medium is strictly prohibited
  *  Proprietary and confidential
  *  Written by Competition Labs Ltd, 2017
  */
package com.competitionlabs.transformers.factory

import com.competitionlabs.transformers.domain._
import com.competitionlabs.transformers.domain.WebhookSettings
import com.competitionlabs.transformers.impl.DefaultWebhookTransformer
import com.competitionlabs.transformers.{CLWebhookTransformer, CompetitionLabsApiExt}

object CLWebhookTransformerFactory {

	val defaultWebhookTransformer = new DefaultWebhookTransformer

	def apply[T <: WebhookTransformerTrigger](trigger : T, settings: WebhookSettings, competitionLabsApi: CompetitionLabsApiExt, cLWebhookTransformer: CLWebhookTransformer = defaultWebhookTransformer) = trigger match {

		case t: onNewProductTrigger => cLWebhookTransformer.onNewProduct(settings, t.productId, competitionLabsApi)

		case t: onNewMemberTrigger => cLWebhookTransformer.onNewMember(settings, t.memberId, competitionLabsApi)

		case t: onCompetitionCreatedTrigger => cLWebhookTransformer.onCompetitionCreated(settings, t.competitionId, competitionLabsApi)

		case t: onCompetitionStartedTrigger => cLWebhookTransformer.onCompetitionStarted(settings, t.competitionId, competitionLabsApi)

		case t: onCompetitionFinishedTrigger => cLWebhookTransformer.onCompetitionFinished(settings, t.competitionId, competitionLabsApi)

		case t: onCompetitionCancelledTrigger => cLWebhookTransformer.onCompetitionCancelled(settings, t.competitionId, competitionLabsApi)

		case t: onCompetitionRewardIssuedTrigger => cLWebhookTransformer.onCompetitionRewardIssued(settings, t.competitionId, t.memberId, t.awardId, competitionLabsApi)

		case t: onContestCreatedTrigger => cLWebhookTransformer.onContestCreated(settings, t.contestId, competitionLabsApi)

		case t: onContestStartedTrigger => cLWebhookTransformer.onContestStarted(settings, t.contestId, competitionLabsApi)

		case t: onContestFinishedTrigger => cLWebhookTransformer.onContestFinished(settings, t.contestId, competitionLabsApi)

		case t: onContestFinalisedTrigger => cLWebhookTransformer.onContestFinalised(settings, t.contestId, competitionLabsApi)

		case t: onContestCancelledTrigger => cLWebhookTransformer.onContestCancelled(settings, t.contestId, competitionLabsApi)

		case t: onContestRewardIssuedTrigger => cLWebhookTransformer.onContestRewardIssued(settings, t.contestId, t.memberId, t.awardId, competitionLabsApi)

		case t: onAchievementCreatedTrigger => cLWebhookTransformer.onAchievementCreated(settings, t.achievementId, competitionLabsApi)

		case t: onAchievementTriggeredTrigger => cLWebhookTransformer.onAchievementTriggered(settings, t.achievementId, t.memberId, competitionLabsApi)
			
		case t: onAchievementRewardIssuedTrigger => cLWebhookTransformer.onAchievementRewardIssued(settings, t.achievementId, t.memberId, t.awardId, competitionLabsApi)

	}
}
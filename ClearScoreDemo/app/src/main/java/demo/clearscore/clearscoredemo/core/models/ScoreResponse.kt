package demo.clearscore.clearscoredemo.core.models

/**
 * Created by Horatiu on 5/16/2018.
 */
data class ScoreResponse(val accountIDVStatus: String,
                         val creditReportInfo: CreditInfo,
                         val dashboardStatus: String,
                         val personaType: String,
                         val coachingSummary: CoachingSummary,
                         val augmentedCreditScore: Any)


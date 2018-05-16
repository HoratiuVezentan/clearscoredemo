package demo.clearscore.clearscoredemo.core.models

/**
 * Created by Horatiu on 5/16/2018.
 */
data class CoachingSummary(val activeTodo: Boolean,
                           val activeChat: Boolean,
                           val numberOfTodoItems: Int,
                           val numberOfCompletedTodoItems: Int,
                           val selected: Boolean)
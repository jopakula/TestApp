package com.example.testapp.ui.viewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel
import com.example.testapp.data.models.Question
import com.example.testapp.data.storage.questions

class TrainingTestViewModel : ViewModel() {
    private val _currentQuestionId = mutableIntStateOf(1)
    val currentQuestionId: State<Int> get() = _currentQuestionId

    private val _correctAnswersCount = mutableIntStateOf(0)
    val correctAnswersCount: State<Int> get() = _correctAnswersCount

    val currentQuestion: Question? get() = questions.find { it.id == _currentQuestionId.intValue }

    fun markAnswer(correct: Boolean) {
        if (correct) {
            _correctAnswersCount.intValue++
        }
    }

    fun moveToNextQuestion() {
        if (_currentQuestionId.intValue < questions.size) {
            _currentQuestionId.intValue++
        }
    }

    fun isLastQuestion(): Boolean {
        return _currentQuestionId.intValue == questions.size
    }
}

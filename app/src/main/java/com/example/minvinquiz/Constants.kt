package com.example.minvinquiz

object Constants {

    const val PLAYER: String = "user_name"
    const val TOTAL_QUESTIONS: String= "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"


    fun getQuestions(): ArrayList<Question>
    {
        val questionsList = ArrayList<Question>()
        val que1= Question(1,
        "What is the greatest two digit number?",
        "11",
        "99",
        "1",
        "10",
        2)

        val que2= Question(2,
            "How much is 180-55+14",
            "164",
            "138",
            "139",
            "269",
            3)

        val que3= Question(3,
            "Find the value of x; " +
                    "if x = (2x6)+11 ",
            "20",
            "24",
            "23",
            "22", 3)
        val que4= Question(4,
            "How much is 90-16",
            "74",
            "89",
            "84",
            "71", 1)
        val que5= Question(5,
            "How much is 55x2",
            "115",
            "110",
            "100",
            "120", 2)
        val que6= Question(6,
            "19+...=42",
            "23",
            "22",
            "21",
            "24", 1)
        val que7= Question(7,
            "50x50=?",
            "25",
            "500",
            "2525",
            "2500", 4)
        val que8= Question(8,
            "25x25=?",
            "625",
            "752",
            "255",
            "454", 1)
        val que9= Question(9,
            "The smallest number of seven digits is...",
            "9999999",
            "1000000",
            "0",
            "1010100", 2)
        val que10= Question(10,
            "Arrange the numbers in ascending order: 35,10,15,24,9",
            "35,24,15,10,9",
            "9,10,14,24,35",
            "9,10,14,25,35",
            "9,10,15,24,35", 4)

        questionsList.add(que1)
        questionsList.add(que2)
        questionsList.add(que3)
        questionsList.add(que4)
        questionsList.add(que5)
        questionsList.add(que6)
        questionsList.add(que7)
        questionsList.add(que8)
        questionsList.add(que9)
        questionsList.add(que10)
        return questionsList


    }
}
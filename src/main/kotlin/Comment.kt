data class Comment(
    val noteId: Int, // Идентификатор заметки.
    val replyTo: Int?, //Идентификатор пользователя, ответом на комментарий которого является добавляемый комментарий (не передаётся, если комментарий не является ответом).
    val message: String, //Текст комментария.
    val isDelete: Boolean, // флаг указывает удаленный (true) комментарий или активный (false)


){

}

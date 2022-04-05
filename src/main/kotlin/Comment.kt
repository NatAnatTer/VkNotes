data class Comment(
    val noteId: UInt, // Идентификатор заметки.
    val replyTo: UInt?, //Идентификатор пользователя, ответом на комментарий которого является добавляемый комментарий (не передаётся, если комментарий не является ответом).
    val message: String, //Текст комментария.
    val isDelete: Boolean, // флаг указывает удаленный (true) комментарий или активный (false)
    val dateCreate: UInt //Дата создания комментария
) {
    private val commentId = NoteService.setCommentId()
    fun getIdComment(): UInt = this.commentId

}

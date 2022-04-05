data class Comment(
    val noteId: UInt, // Идентификатор заметки.
    val replyTo: UInt?, //Идентификатор пользователя, ответом на комментарий которого является добавляемый комментарий (не передаётся, если комментарий не является ответом).
    val message: String, //Текст комментария.
    var isDelete: Boolean, // флаг указывает удаленный (true) комментарий или активный (false)
    val dateCreate: Long //Дата создания комментария
) {
    private var commentId = NoteService.setCommentId()
    fun getIdComment(): UInt = this.commentId
    fun editCommentId(idComment: UInt) {
        this.commentId = idComment
    }
}

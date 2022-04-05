data class Note(

    val title: String, // Заголовок заметки.
    val text: String, // Текст заметки.
    val privacyView: String, // настройки приватности просмотра заметки в специальном формате.список слов, разделенных через запятую, по умолчанию all,
    val privacyComment: String, // Настройки приватности комментирования заметки в специальном формате.
    var isDelete: Boolean, // флаг указывает заметка удалена (true) или активная (false)
    val dateCreate: Long //Дата создания заметки

) {
    private var id: UInt = NoteService.setNoteId() // Идентификатор заметки.
    fun getNoteId() = this.id
    fun editNoteId(idNote: UInt) {
        this.id = idNote
    }


}
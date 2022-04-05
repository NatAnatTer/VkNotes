data class Note(

    val title: String, // Заголовок заметки.
    val text: String, // Текст заметки.
    val privacy: Int, //Уровень доступа к заметке.
    val commentPrivacy: Int, // Уровень доступа к комментированию заметки.
    val privacyView: String, // настройки приватности просмотра заметки в специальном формате.список слов, разделенных через запятую, по умолчанию all,
    val privacyComment: String, // Настройки приватности комментирования заметки в специальном формате.
    var isDelete: Boolean, // флаг указывает заметка удалена (true) или активная (false)
    val dateCreate: UInt //Дата создания заметки
    // val canComment: Boolean, // настройки приватности комментирования заметки в специальном формате. список слов, разделенных через запятую, по умолчанию all
    // val textWiki: String // Тэги ссылок на wiki
    // val date: Int, // Дата создания заметки в формате Unixtime.
    // val comments: Int, // Количество комментариев.
    //  val readComments: Int, //Количество прочитанных комментариев (только при запросе информации о заметке текущего пользователя).
    // val viewUrl: String, // URL страницы для отображения заметки.
) {
    private var id: UInt = NoteService.setNoteId() // Идентификатор заметки.
    fun getNoteId() = this.id
    fun editNoteId(idNote: UInt){
        this.id = idNote
    }



}
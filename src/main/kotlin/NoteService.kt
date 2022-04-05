object NoteService {

    private val notes = mutableListOf<Note>()
    private val comments = mutableListOf<Comment>()

    var lastId = 0U
    fun setNoteId(): UInt {
        lastId += 1U
        return lastId
    }

    var lastCommentId = 0U
    fun setCommentId(): UInt {
        lastCommentId += 1U
        return lastCommentId
    }

    fun printNoteList() {
        println("------------------------------------------------------")
        println("Note:")
        for (note in notes) {
            println("Id note: ${note.getNoteId()}")
            println(note)
        }
    }

    fun add(title: String, text: String, privacyView: String, privacyComment: String): UInt {
        val note = Note(title, text, privacyView, privacyComment, false, System.currentTimeMillis())
        notes.add(note)
        return note.getNoteId()
    }

    fun add(noteId: UInt, replyTo: UInt, message: String): UInt {
        val comment = Comment(noteId, replyTo, message, false, System.currentTimeMillis())
        comments.add(comment)
        return comment.getIdComment()

    }


    @Throws(NoteDeletedException::class)
    fun notesDelete(noteId: UInt): Boolean {
        for (note in notes) {
            if (note.getNoteId() == noteId && !note.isDelete) {
                note.isDelete = true
                return true
            } else if (note.getNoteId() == noteId && note.isDelete) {
                ;throw NoteDeletedException("Заметка уже удалена")
            }
        }
        return false
    }

    fun notesEdit(note: Note): Boolean {
        for ((index, noteEdited) in notes.withIndex()) {
            // for (noteEdited in notes) {
            if (noteEdited.getNoteId() == note.getNoteId() && !noteEdited.isDelete) {
                notes[index] = noteEdited.copy(
                    title = note.title,
                    text = note.text,
                    privacyView = note.privacyView,
                    privacyComment = note.privacyComment
                )
                notes[index].editNoteId(note.getNoteId())
                println("noteEdited ID = ${noteEdited.getNoteId()}")
                println(note)
                return true
            } else if (noteEdited.getNoteId() == note.getNoteId() && noteEdited.isDelete) {
                ;throw NoteDeletedException("Эта заметка удалена")
            }
        }
        return false
    }

    fun notesGet(noteIds: String, offset: Int, count: Int, sort: UInt): List<Note> {
        val resultList = mutableListOf<Note>()
        val ids = noteIds.split(", ")
        val range = offset..offset + count
        println(range)
        for (i in range) {
            val intId: UInt = ids.getOrNull(i)?.toUInt() ?: continue
            for (note in notes) {
                if (note.getNoteId() == intId && !note.isDelete) {
                    resultList.add(note)

                }
            }
        }
        if (sort == 1U) {
            return resultList.sortedBy { it.dateCreate }
        }
        return resultList.sortedByDescending { it.dateCreate }

    }

    fun notesGetById(noteId: UInt): Note {
        for (note in notes) {
            if (note.getNoteId() == noteId && !note.isDelete) {
                return note
            } else if (note.getNoteId() == noteId && note.isDelete) {
                throw NoteDeletedException("Эта заметка удалена")
            }
        }
        throw NoteDeletedException("Заметка не найдена")
    }


    fun notesDeleteComment() {
//    Удаляет комментарий к заметке.
//
//
//
//    Параметры
//    comment_id
//    positive
//
//    Идентификатор комментария.
//
//    owner_id
//    positive
//
//    Идентификатор владельца заметки.
//
//    Результат
//    После успешного выполнения возвращает 1.
    }


    fun notesEditComment() {
//    Редактирует указанный комментарий у заметки.
//
//
//    Параметры
//    comment_id
//    positive
//
//    Идентификатор комментария.
//
//    owner_id
//    positive
//
//    Идентификатор владельца заметки.
//
//    message
//    string
//
//    Новый текст комментария.
//
//    Результат
//    После успешного выполнения возвращает 1.
    }


    fun notesGetComments() {
//    Возвращает список комментариев к заметке.
//
//    Параметры
//    note_id
//    positive
//
//    Идентификатор заметки.
//
//    owner_id
//    positive
//
//    Идентификатор владельца заметки.
//
//    sort
//    positive
//
//    Сортировка результатов (0 — по дате добавления в порядке возрастания, 1 — по дате добавления в порядке убывания).
//
//    offset
//    positive
//
//    Смещение, необходимое для выборки определенного подмножества комментариев.
//
//    count
//    positive
//
//    Количество комментариев, которое необходимо получить.
    }

    fun notesRestoreComment() {
//    Восстанавливает удалённый комментарий.
//
//    Этот метод можно вызвать с ключом доступа пользователя, полученным в Standalone-приложении через Implicit Flow.
//
//    Требуются права доступа: notes.
//
//    Параметры
//    comment_id
//    positive
//
//    Идентификатор удаленного комментария.
//
//    owner_id
//    positive
//
//    Идентификатор владельца заметки.
    }
}



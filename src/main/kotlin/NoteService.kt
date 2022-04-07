object NoteService {

    val notes = mutableListOf<Note>()
    val comments = mutableListOf<Comment>()


    fun setLastId1(lastIdForTest: UInt){
        lastId = lastIdForTest
    }
    fun setLastCommentId1(lastCommentIdForTest: UInt){
        lastCommentId = lastCommentIdForTest
    }

    private var lastId = 0U

    fun setNoteId(): UInt {
        lastId += 1U
        return lastId
    }

    private var lastCommentId = 0U
    fun setCommentId(): UInt {
        lastCommentId += 1U
        return lastCommentId
    }

//    fun printNoteList() {
//        println("------------------------------------------------------")
//        println("Note:")
//        for (note in notes) {
//            println("Id note: ${note.getNoteId()}")
//            println(note)
//        }
//        for (comment in comments) {
//            println("Id comment: ${comment.getIdComment()}")
//            println(comment)
//        }
//    }

    fun add(title: String, text: String, privacyView: String, privacyComment: String): UInt {
        val note = Note(title, text, privacyView, privacyComment, false, System.currentTimeMillis())
        notes.add(note)
        return note.getNoteId()
    }

    fun addComment(noteId: UInt, replyTo: UInt, message: String): UInt {
        val comment = Comment(noteId, replyTo, message, false, System.currentTimeMillis())
        comments.add(comment)
        return comment.getIdComment()

    }


    @Throws(NoteDeletedException::class)
    fun delete(noteId: UInt): Boolean {
        for (note in notes) {
            if (note.getNoteId() == noteId && !note.isDelete) {
                note.isDelete = true
                return true
            } else if (note.getNoteId() == noteId && note.isDelete) {
                throw NoteDeletedException("Заметка уже удалена")
            }
        }
        return false
    }

    @Throws(NoteDeletedException::class)
    fun deleteComment(commentId: UInt): Boolean {
        for (comment in comments) {
            if (comment.getIdComment() == commentId && !comment.isDelete) {
                comment.isDelete = true
                return true
            } else if (comment.getIdComment() == commentId && comment.isDelete) {
                throw NoteDeletedException("Комментарий уже удален")
            }
        }
        return false
    }

    @Throws(NoteDeletedException::class)
    fun edit(noteId: UInt, title: String, text: String, privacyView: String, privacyComment: String): Boolean {
        for ((index, noteEdited) in notes.withIndex()) {
            if (noteEdited.getNoteId() == noteId && !noteEdited.isDelete) {
                notes[index] = noteEdited.copy(
                    title = title,
                    text = text,
                    privacyView = privacyView,
                    privacyComment = privacyComment
                )
                notes[index].editNoteId(noteId)
                println("noteEdited ID = ${noteEdited.getNoteId()}")
                return true
            } else if (noteEdited.getNoteId() == noteId && noteEdited.isDelete) {
                throw NoteDeletedException("Эта заметка удалена")
            }
        }
        return false
    }

    @Throws(NoteDeletedException::class)
    fun editComment(commentId: UInt, message: String): Boolean {
        for ((index, comment) in comments.withIndex()) {
            if (comment.getIdComment() == commentId && !comment.isDelete) {
                comments[index] = comment.copy(
                    message = message
                )
                comments[index].editCommentId(commentId)
                println("commentEdited ID = ${comment.getIdComment()}")
                return true
            } else if (comment.getIdComment() == commentId && comment.isDelete) {
                throw NoteDeletedException("Комментарий удален")
            }
        }
        return false
    }

    fun get(noteIds: String, offset: Int, count: Int, sort: UInt): List<Note> {
        val resultList = mutableListOf<Note>()
        val ids = noteIds.split(", ")
        val range = offset..offset + count
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

    fun getComment(noteId: UInt, offset: Int, count: Int, sort: UInt): List<Comment> {
        val resultList = mutableListOf<Comment>()
        for (note in notes) {
            if (note.getNoteId() == noteId && !note.isDelete) {
                val lastIndex = comments.lastIndex
                val range: Int = if (offset + count <= lastIndex) {
                    offset + count
                } else {
                    lastIndex
                }

                for (i in offset..range) {
                    if (comments[i].noteId == noteId && !comments[i].isDelete) {
                        resultList.add(comments[i])
                    } else if (comments[i].noteId == noteId && !comments[i].isDelete) {
                        throw NoteDeletedException("Комментарий удален")
                    }
                }
            } else if (note.getNoteId() == noteId && !note.isDelete) {
                throw NoteDeletedException("Заметка удалена")
            }
        }

        if (sort == 1U) {
            return resultList.sortedBy { it.dateCreate }
        }
        return resultList.sortedByDescending { it.dateCreate }

    }
    @Throws(NoteDeletedException::class)
    fun restoreComment(commentId: UInt): Boolean {
        for (comment in comments) {
            if (comment.getIdComment() == commentId && comment.isDelete) {
                comment.isDelete = false
                return true
            } else if (comment.getIdComment() == commentId && !comment.isDelete) {
                throw NoteDeletedException("Комментарий не удален")
            }
        }
        return false
    }
}



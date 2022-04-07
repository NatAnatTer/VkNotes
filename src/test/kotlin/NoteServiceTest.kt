import NoteService.add
import NoteService.addComment
import NoteService.comments
import NoteService.delete
import NoteService.deleteComment
import NoteService.edit
import NoteService.editComment
import NoteService.notes
import NoteService.setCommentId
import NoteService.setLastCommentId1
import NoteService.setLastId1
import NoteService.setNoteId
import org.junit.Assert.*
import org.junit.Test

class NoteServiceTest {

//    @Test
//    fun getLastId() {
//    }

//    @Test
//    fun setLastId() {
//    }

    @Test
    fun setNoteIdTest() {
        setLastId1(1U)
        val result = setNoteId()
        assertEquals(2U, result)
    }
//
//    @Test
//    fun getLastCommentId() {
//    }
//
//    @Test
//    fun setLastCommentId() {
//    }

    @Test
    fun setCommentIdTest() {
        setLastCommentId1(1U)
        val result = setCommentId()
        assertEquals(2U, result)
    }

    @Test
    fun addTest() {
        setLastId1(0U)
        val titleTest = "First note"
        val textTest = "Text first note"
        val privacyViewTest = "all"
        val privacyCommentTest = "all"
        val result = add(
            title = titleTest,
            text = textTest,
            privacyView = privacyViewTest,
            privacyComment = privacyCommentTest
        )
        assertEquals(1U, result)
    }

    @Test
    fun addToCollectionTest() {
        setLastId1(0U)
        val titleTest = "First note"
        val textTest = "Text first note"
        val privacyViewTest = "all"
        val privacyCommentTest = "all"
        add(
            title = titleTest,
            text = textTest,
            privacyView = privacyViewTest,
            privacyComment = privacyCommentTest
        )
        assertTrue(notes.isNotEmpty())
    }

    @Test
    fun testAddComment() {
        setLastCommentId1(0U)
        setLastId1(0U)
        notes.clear()
        comments.clear()
        add(
            title = "First note",
            text = "Text first note",
            privacyView = "all",
            privacyComment = "all"
        )
        val noteIdTest = 1U
        val replyToTest = 1U
        val messageTest = "First comment"
        val result = addComment(
            noteId = noteIdTest,
            replyTo = replyToTest,
            message = messageTest
        )
        assertEquals(1U, result)
    }

    @Test
    fun deleteTest() {
        setLastCommentId1(0U)
        setLastId1(0U)
        notes.clear()
        comments.clear()
        add(
            title = "First note",
            text = "Text first note",
            privacyView = "all",
            privacyComment = "all"
        )
        val noteIdTest = 1U
        val result = delete(noteIdTest)
        assertTrue(result)
    }

    @Test
    fun deleteTestFalse() {
        setLastCommentId1(0U)
        setLastId1(0U)
        notes.clear()
        comments.clear()
        add(
            title = "First note",
            text = "Text first note",
            privacyView = "all",
            privacyComment = "all"
        )
        val noteIdTest = 2U
        val result = delete(noteIdTest)
        assertFalse(result)
    }

    @Test(expected = NoteDeletedException::class)
    fun deleteTestException() {
        setLastCommentId1(0U)
        setLastId1(0U)
        notes.clear()
        comments.clear()
        add(
            title = "First note",
            text = "Text first note",
            privacyView = "all",
            privacyComment = "all",
        )
        for (note in notes) {
            note.isDelete = true
        }
        val noteIdTest = 1U
        delete(noteIdTest)
        AssertionError("Заметка уже удалена")
    }


    @Test
    fun deleteCommentTest() {
        setLastCommentId1(0U)
        setLastId1(0U)
        notes.clear()
        comments.clear()
        add(
            title = "First note",
            text = "Text first note",
            privacyView = "all",
            privacyComment = "all"
        )
        addComment(
            noteId = 1U,
            replyTo = 1U,
            message = "First comment"
        )
        val result = deleteComment(1U)
        assertTrue(result)
    }

    @Test
    fun deleteCommentTestFalse() {
        setLastCommentId1(0U)
        setLastId1(0U)
        notes.clear()
        comments.clear()
        add(
            title = "First note",
            text = "Text first note",
            privacyView = "all",
            privacyComment = "all"
        )
        addComment(
            noteId = 1U,
            replyTo = 1U,
            message = "First comment"
        )
        val result = deleteComment(2U)
        assertFalse(result)
    }

    @Test(expected = NoteDeletedException::class)
    fun deleteCommentTestException() {
        setLastCommentId1(0U)
        setLastId1(0U)
        notes.clear()
        comments.clear()
        add(
            title = "First note",
            text = "Text first note",
            privacyView = "all",
            privacyComment = "all"
        )
        addComment(
            noteId = 1U,
            replyTo = 1U,
            message = "First comment"
        )
        for (comment in comments) {
            comment.isDelete = true
        }
        deleteComment(1U)
        AssertionError("Комментарий уже удален")
    }

    @Test
    fun editTest() {
        setLastCommentId1(0U)
        setLastId1(0U)
        notes.clear()
        comments.clear()
        add(
            title = "First note",
            text = "Text first note",
            privacyView = "all",
            privacyComment = "all",
        )
        val noteIdTest = 1U
        val titleTest = "Edited note"
        val textTest = "Note is edited"
        val privacyViewTest = "all"
        val privacyCommentTest = "all"
        val result = edit(
            noteId = noteIdTest,
            title = titleTest,
            text = textTest,
            privacyView = privacyViewTest,
            privacyComment = privacyCommentTest
        )
        assertTrue(result)
    }

    @Test
    fun editTestFalse() {
        setLastCommentId1(0U)
        setLastId1(0U)
        notes.clear()
        comments.clear()
        add(
            title = "First note",
            text = "Text first note",
            privacyView = "all",
            privacyComment = "all",
        )
        val noteIdTest = 2U
        val titleTest = "Edited note"
        val textTest = "Note is edited"
        val privacyViewTest = "all"
        val privacyCommentTest = "all"
        val result = edit(
            noteId = noteIdTest,
            title = titleTest,
            text = textTest,
            privacyView = privacyViewTest,
            privacyComment = privacyCommentTest
        )
        assertFalse(result)
    }

    @Test(expected = NoteDeletedException::class)
    fun editTestException() {
        setLastCommentId1(0U)
        setLastId1(0U)
        notes.clear()
        comments.clear()
        add(
            title = "First note",
            text = "Text first note",
            privacyView = "all",
            privacyComment = "all",
        )
        val noteIdTest = 1U
        val titleTest = "Edited note"
        val textTest = "Note is edited"
        val privacyViewTest = "all"
        val privacyCommentTest = "all"
        for (note in notes) {
            note.isDelete = true
        }
        edit(
            noteId = noteIdTest,
            title = titleTest,
            text = textTest,
            privacyView = privacyViewTest,
            privacyComment = privacyCommentTest
        )
    }

    @Test
    fun editCommentTest() {
        setLastCommentId1(0U)
        setLastId1(0U)
        notes.clear()
        comments.clear()
        add(
            title = "First note",
            text = "Text first note",
            privacyView = "all",
            privacyComment = "all",
        )
        addComment(
            noteId = 1U,
            replyTo = 1U,
            message = "First comment"
        )
        val commentIdTest = 1U
        val messageTest = "Edited comment"
        val result = editComment(commentIdTest, messageTest)
        assertTrue(result)
    }

    @Test
    fun editCommentTestFalse() {
        setLastCommentId1(0U)
        setLastId1(0U)
        notes.clear()
        comments.clear()
        add(
            title = "First note",
            text = "Text first note",
            privacyView = "all",
            privacyComment = "all",
        )
        addComment(
            noteId = 1U,
            replyTo = 1U,
            message = "First comment"
        )
        val commentIdTest = 2U
        val messageTest = "Edited comment"
        val result = editComment(commentIdTest, messageTest)
        assertFalse(result)
    }

    @Test(expected = NoteDeletedException::class)
    fun editCommentTestException() {
        setLastCommentId1(0U)
        setLastId1(0U)
        notes.clear()
        comments.clear()
        add(
            title = "First note",
            text = "Text first note",
            privacyView = "all",
            privacyComment = "all",
        )
        addComment(
            noteId = 1U,
            replyTo = 1U,
            message = "First comment"
        )
        for (comment in comments) {
            comment.isDelete = true
        }
        val commentIdTest = 1U
        val messageTest = "Edited comment"
        editComment(commentIdTest, messageTest)
    }


    @Test
    fun getTest() {

        setLastCommentId1(0U)
        setLastId1(0U)
        notes.clear()
        comments.clear()
        add(
            title = "First note",
            text = "Text first note",
            privacyView = "all",
            privacyComment = "all",
        )
        add(
            title = "Second note",
            text = "Text Second note",
            privacyView = "all",
            privacyComment = "all",
        )
        val noteIds = "1, 2"
        val offset = 0
        val count = 20
        val sort = 0U

    }

    @Test
    fun notesGetById() {
    }

    @Test
    fun getComment() {
    }

    @Test
    fun restoreComment() {
    }
}



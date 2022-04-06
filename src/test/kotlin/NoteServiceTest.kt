import NoteService.lastId
import NoteService.setCommentId
import NoteService.setLastCommentId1

import NoteService.setLastId1
import NoteService.setNoteId
import org.junit.Test

import org.junit.Assert.*

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
      val  result = setNoteId()
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
    fun printNoteList() {
    }

    @Test
    fun add() {
    }

    @Test
    fun testAdd() {
    }

    @Test
    fun delete() {
    }

    @Test
    fun deleteComment() {
    }

    @Test
    fun edit() {
    }

    @Test
    fun editComment() {
    }

    @Test
    fun get() {
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
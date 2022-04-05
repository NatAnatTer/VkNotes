fun main() {

    val note1 = Note("1 NOTE", "Text 1 note", 1, 1, "all", "all", false, 111111U)
    val note2 = Note("2 NOTE", "Text 2 note", 1, 1, "all", "all", false, 222222U)
    val note3 = Note("3 NOTE", "Text 3 note", 1, 1, "all", "all", false, 333333U)
    val note4 = Note("4 NOTE", "Text 4 note", 1, 1, "all", "all", false, 444444U)
    val note5 = Note("5 NOTE", "Text 5 note", 1, 1, "all", "all", false, 444444U)

    // note4.editNoteId(1U)
  //  println("Id: ${note4.getNoteId()} note: $note4")
    val obj = NoteService
    obj.add(note1)
    obj.add(note2)
    obj.add(note3)
    obj.add(note4)
    obj.add(note5)
  //  obj.printNoteList()
 //  println(obj.notesEdit(note4))
    obj.printNoteList()

    //println(obj.notesDelete(1U))
   // println(obj.notesDelete(2U))
    //println(obj.notesDelete(1U))
println("#############################")
   println( obj.notesGet("1, 2, 3, 4, 5", 0, 20,0U))

}

fun main() {

    val note1 = Note("1 NOTE", "Text note", 1, 1, "all", "all", false)
    val note2 = Note("2 NOTE", "Text note", 1, 1, "all", "all", false)
    val note3 = Note("3 NOTE", "Text note", 1, 1, "all", "all", false)
    val note4 = Note("4 NOTE", "Text note", 1, 1, "all", "all", false)
    val obj = NoteService
    obj.add(note1)
    obj.add(note2)
    obj.add(note3)
    obj.add(note4)
    obj.printNoteList()
}
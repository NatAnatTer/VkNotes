fun main() {


    val obj = NoteService
    println(obj.add("One 1 note", "Including note", "all", "all"))
    println(obj.add("Two 2 note", "Including note", "all", "all"))
    println(obj.add("Three 3 note", "Including note", "all", "all"))
    println(obj.add("Four 4 note", "Including note", "all", "all"))
    println(obj.add("Five 5 note", "Including note", "all", "all"))
    println(obj.add(1U, 1U, "FirstComment"))
    println(obj.add(1U, 1U, "2 Comment"))
    println(obj.add(1U, 1U, "3 Comment"))
    println(obj.add(1U, 1U, "4 Comment"))
  //  obj.printNoteList()

//    println("############################")
//    obj.delete(1U)
//    obj.delete(4U)
    obj.deleteComment(1U)
    obj.deleteComment(3U)
    obj.printNoteList()
//
//    println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@")
//    obj.edit(2U, "2 edited", "edited 222", "all", "all")
//    obj.editComment(3U, "3 edited comment")
//    obj.edit(1U, "123432", "2312312", "all", "all")
//    obj.editComment(2U, "2 edited comment")
//    obj.printNoteList()
//
//    println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%")
//    println(obj.get("1, 2, 3, 5", 0, 20, 0U))
    println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$")
//    println(obj.notesGetById(4U))
//    println(obj.getComment(1U, 0, 2, 0U))
    println(obj.restoreComment(1U))
//    println(obj.restoreComment(4U))
    obj.printNoteList()
}
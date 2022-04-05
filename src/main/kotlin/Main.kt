fun main() {


    val obj = NoteService
    println(obj.add("One 1 note", "Including note", "all", "all"))
    println(obj.add("Two 2 note", "Including note", "all", "all"))
    println(obj.add("Three 3 note", "Including note", "all", "all"))
    println(obj.add("Four 4 note", "Including note", "all", "all"))
    println(obj.add("Five 5 note", "Including note", "all", "all"))
    println(obj.add(1U,1U,"FirstComment"))
    println(obj.add(1U,1U,"2 Comment"))
    println(obj.add(2U,1U,"3 Comment"))
    println(obj.add(4U,1U,"4 Comment"))
    obj.printNoteList()


}
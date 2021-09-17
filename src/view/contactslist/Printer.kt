package view.contactslist
import domain.model.Contact

object Printer {
    fun printAllContacts(list: List<Contact>) {
        var i=1
        for (contact in list) {
            println("$i."+contact.name)
            i += 1
        }
    }

    fun printContact(i:Contact?)
    {
        println("Name : ${i?.name}")
        println("Address : ${i?.address}")
        println("Emailid : ${i?.emailId}")
        println("Contact number :")
        var x=1
        for (j in i?.phone!!)
        {
            println("$x) $j")
            x+=1
        }
    }


}
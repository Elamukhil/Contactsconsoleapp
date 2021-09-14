package view.contactslist
import data.Contactsdata
import domain.model.Contacts

object Printer {
    fun printAllContacts(list: List<Contacts>) {
        var i=1
        for (contact in list) {
            println("$i."+contact.name)
            i += 1
        }
    }

    fun printContact(i:Contacts)
    {
        println("Name : ${i.name}")
        println("Address : ${i.address}")
        println("Emailid : ${i.emailid}")
        println("Phone : ${i.phone}")
    }


}
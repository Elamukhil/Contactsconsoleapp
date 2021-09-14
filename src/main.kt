import data.Contactsdata
import domain.model.Contacts

suspend fun main(args: Array<String>) {
    Contactsdata.addNewContact(Contacts("John", "ABC", "John@gmail.com", "123456", true))
    Contactsdata.addNewContact(Contacts("Ram", "ABC", "Ram@gmail.com", "123456", false))
    val presenter = Injection.provideContactPresenter()
    while (true) {
        println(
            "Choose from the menu\n1.List contacts\n2.Add contact \n3.List favourite contacts\n4.Quit"
        )
        val input = Integer.valueOf(readLine())
        if (input == 1) {
            presenter.getAllContacts()
            println("Choose contact to expand ")
            val input = Integer.valueOf(readLine())

            presenter?.getContactDetail(input - 1)
            println(
                "Choose from the menu\n1.Favourite contacts\n2.Unfavourite contact\n" +
                        "3.Edit contact\n" +
                        "4.Delete contact\n5.Back to main menu"
            )
            val input1 = Integer.valueOf(readLine())
            if (input1 == 1) {
                    presenter.favouriteContact(true,input-1)
            }
            if (input1 == 2) {
                presenter.favouriteContact(false,input-1)
            }
            if (input1 == 3) {
                println("Enter the parameter to be edited\n1.Name\n2.Address\n3.Emailid\n4.Phone number")
                val input2 = Integer.valueOf(readLine())
                var input3: String? = null
                if (input2 == 1) {
                    println("Enter the name")
                    input3 = readLine()
                    presenter?.editContact(input - 1, input3!!, 1)
                } else if (input2 == 2) {
                    println("Enter the Address")
                    input3 = readLine()
                    presenter?.editContact(input - 1, input3!!, 2)
                } else if (input2 == 3) {
                    println("Enter the Email")
                    input3 = readLine()
                    presenter?.editContact(input - 1, input3!!, 3)
                }
                if (input2 == 4) {
                    println("Enter the Phone number")
                    input3 = readLine()
                    presenter?.editContact(input - 1, input3!!, 4)
                }
            }
                if(input1==4)
                {
                    presenter.deleteContact(input-1)
                }
                if (input1 == 5)
                    continue

        }
            if (input == 2) {
                println("Enter your name")
                val name = readLine()
                println("Enter your emailid")
                val emailid = readLine()
                println("Enter your contact number")
                val contactnumber = readLine()
                println("Enter your address")
                val address = readLine()
                var favourite = false
                println("Do you want to make contact favourite\n 1.Yes \n 2.No")
                val input1 = Integer.valueOf(readLine())
                if (input1 == 1)
                    favourite = true
                presenter?.addContact(Contacts(name!!, emailid!!, contactnumber!!, address!!, favourite))

            }
            if (input == 3) {
                presenter.getFavouriteContacts()
                println("Choose contact to expand ")
                val input3 = Integer.valueOf(readLine())
                presenter?.getContactDetail(input3 - 1)
            }
            if(input==4)
                break


    }
}

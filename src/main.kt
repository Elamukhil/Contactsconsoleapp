import data.ContactsData
import domain.model.Address
import domain.model.Contact
import view.contactslist.Printer
import kotlin.random.Random

suspend fun main(args: Array<String>) {
    ContactsData.addNewContact(Contact(Random.nextInt(0,1000),"John", Address("233","Nethaji street","Coimbatore","TamilNadu","614003"), "John@gmail.com", mutableListOf("123456"), true))
    ContactsData.addNewContact(Contact(Random.nextInt(0,1000),"Ram", Address("300","Ramnagar street","Coimbatore","TamilNadu","614045"), "Ram@gmail.com", mutableListOf("123456","567890"), false))
    val presenter = Injection.provideContactPresenter()
    while (true) {
        println(
            "Choose from the menu\n1.List contacts\n2.Add contact \n3.List favourite contacts\n4.Quit"
        )
        val input = Integer.valueOf(readLine())
        if (input == 1) {
            val list=presenter.getAllContacts()
            Printer.printAllContacts(list)
            if(list.isEmpty())
            {
                continue
            }
            println("Choose contact to expand ")
            val input = Integer.valueOf(readLine())
            val temp:Contact? = presenter.getContactDetail(list[input-1].contactId)
            Printer.printContact(temp)
            println(
                "Choose from the menu\n1.Favourite contacts\n2.Unfavourite contact\n" +
                        "3.Edit contact\n" +
                        "4.Delete contact\n5.Back to main menu"
            )
            val input1 = Integer.valueOf(readLine())
            if (input1 == 1) {
                    presenter.favouriteContact(true,list[input-1].contactId)
            }
            if (input1 == 2) {
                presenter.favouriteContact(false,list[input-1].contactId)
            }
            if (input1 == 3) {
                println("Enter the parameter to be edited\n1.Name\n2.Address\n3.Emailid\n4.Phone number")
                val input2 = Integer.valueOf(readLine())
                if (input2 == 1) {
                    println("Enter the name")
                    val name = readLine()
                    val temp=Contact(list[input-1].contactId,name!!,list[input-1].address,list[input-1].emailId,list[input-1].phone,list[input-1].isFavourite)
                    presenter.editContact(temp)
                } else if (input2 == 2) {
                    println("Enter the Address")
                    println("Enter the Door no")
                    val doorNo= readLine()
                    println("Enter the Street name")
                    val streetName= readLine()
                    println("Enter the District")
                    val district= readLine()
                    println("Enter the State")
                    val state= readLine()
                    println("Enter the pinCode")
                    val pinCode= readLine()
                    val temp=Contact(list[input-1].contactId,list[input-1].name,Address(doorNo!!,streetName!!,district!!,state!!,pinCode!!),list[input-1].emailId,list[input-1].phone,list[input-1].isFavourite)
                    presenter.editContact(temp)
                } else if (input2 == 3) {
                    println("Enter the Email")
                    val emailId = readLine()
                    val temp=Contact(list[input-1].contactId,list[input-1].name,list[input-1].address,emailId!!,list[input-1].phone,list[input-1].isFavourite)
                    presenter.editContact(temp)
                }
                if (input2 == 4) {
                    var x=1
                    println("Enter the Phone number to be edited")
                    val phonelist :MutableList<String> = mutableListOf()
                    for(i in list[input-1].phone)
                    {
                        phonelist.add(i)
                        println("$x) $i")
                        x+=1
                    }
                    val option= Integer.valueOf(readLine())
                    println("Enter the number")
                    val phoneNumber = readLine()
                    phonelist[option-1]=phoneNumber!!
                    val temp=Contact(list[input-1].contactId,list[input-1].name,list[input-1].address,list[input-1].emailId,phonelist,list[input-1].isFavourite)
                    presenter.editContact(temp)
                }
            }
                if(input1==4)
                {
                    presenter.deleteContact(list[input-1].contactId)
                }
                if (input1 == 5)
                    continue

        }
            if (input == 2) {
                println("Enter your name")
                val name = readLine()
                println("Enter your emailid")
                val emailid = readLine()
                println("Enter your contact number separated by comma")
                val contactnumber = readLine()?.split(",") as MutableList<String>
                println("Enter your address")
                println("Enter your doorNo")
                val doorNo = readLine()
                println("Enter your streetName")
                val streetName = readLine()
                println("Enter your district")
                val district= readLine()
                println("Enter your state")
                val state= readLine()
                println("Enter your pincode")
                val pinCode= readLine()

                var favourite = false
                println("Do you want to make contact favourite\n 1.Yes \n 2.No")
                val input1 = Integer.valueOf(readLine())
                if (input1 == 1)
                    favourite = true
                presenter.addContact(Contact(Random.nextInt(0,1000),name!!, Address(doorNo!!,streetName!!,district!!,state!!,pinCode!!), emailid!!,contactnumber!!, favourite))

            }
            if (input == 3) {
                val list=presenter.getFavouriteContacts()
                Printer.printAllContacts(list)
                if(list.isEmpty())
                    continue
                println("Choose contact to expand ")
                val input3 = Integer.valueOf(readLine())
                val temp:Contact? = presenter.getContactDetail(list[input3-1].contactId)
                Printer.printContact(temp)
            }
            if(input==4)
                break


    }
}

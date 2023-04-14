/*
Consider that we want to define methods for manipulating a phone book. So we decided that
the information for each entry in the phone book will contain the name, the phone number and
e-mail address.
*/

type Entry = (String, String, String)
type LTelef = List[Entry]

def emails(lst : LTelef) : List[String] = {
  lst match {
    case Nil => Nil
    case (_ , _ , email):: tail => email :: (emails(tail))
  }
}

/* 2i)
Define a method that, given a phone book, produces the list of email addresses of the
entries whose telephone numbers are from the fixed network (prefix ’2’).
*/

def emailPrefix2(lst : LTelef) : List[String] =
{
  lst match {
    case Nil => Nil
    case (_ , phone , email) :: tail => {
      if(phone(0) == '2')email :: (emailPrefix2(tail))
      else
        emailPrefix2(tail)
    }
  }
}

/* 2j)
Define a method that given a phone book and a name, returns the pair with the phone
number and the email address associated with that name, in the phone book.
*/

def pairPhoneEmail(lst : LTelef, name: String) : (String, String) =
{
  lst match {
    case Nil => (" " , " " )
    case (n , phone , email) :: tail => {
      if(name.equals(n))
        (phone, email)
      else
        pairPhoneEmail(tail, name)
    }
  }
}
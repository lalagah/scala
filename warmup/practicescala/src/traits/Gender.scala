package traits

trait Gender { 
	def name: String 
}

object genders {
  object MALE extends Gender{ val name= "male"}
  object FEMALE extends Gender { val name="female"}
}

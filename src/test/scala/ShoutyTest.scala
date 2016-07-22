
import org.scalatest._

/**
  * Created by goncalocastro on 22/07/2016.
  * Shouts are 180 characteres long and are only heard within 10 km
  * Maria the shouter
  * John the listener
  */

class ShoutyAcceptanceTest extends FeatureSpec with GivenWhenThen {
  feature("As a shouty user I want to be able to shout a message to my close network of people") {
    scenario("John broadcasts a message to his network") {
      Given("John is less than 10km away from Maria")
      val john = User("John", (10,53))
      val maria = User("Maria", (10,53))
      val network = Network(List(john, maria))
      When("John shouts'FREE DRINKS!'")
      val listeningUsers = john.shout("FREE DRINKS!", network)
      Then("Maria should hear 'FREE DRINKS!'")
      println(listeningUsers.contains(maria))
    }
  }
}

class ShoutyUnitTest extends FlatSpec with Matchers {
  "User" should "instantiated" in {
    User("John", (10,53)) shouldBe a [User]
  }

  it should "be able to shout a message to another user if he/she is close by" in {
    val shoutyUser = User("John", (10,53))
    val hearingUser = User("Maria", (10,53))
    val notSureUser = User("Pikachu", (100,99))
    val users = List(shoutyUser, hearingUser, notSureUser)
    val network = Network(users)
    shoutyUser.shout("a message", network) shouldBe List(hearingUser)
  }

  "Network" should "have multiple users" in {
    val user1 = User("John", (10,53))
    val user2 = User("Maria", (10,53))
    val users = List(user1, user2)
    val network = Network(users)
    network.users.size shouldBe 2
    network.users.head.name shouldBe "John"
  }

  it should "be able to calculate the distance between users" in {
    val user1 = User("John", (10,54))
    val user2 = User("Maria", (10,53))
    val users = List(user1, user2)
    val network = Network(users)
    network.calculateDistance(user1, user2) shouldBe 1
  }


}


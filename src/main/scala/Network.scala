/**
  * Created by goncalocastro on 22/07/2016.
  */
case class Network(users: List[User]) {
  val MAX_SHOUT_DISTANCE = 10
  def calculateDistance(user1: User, user2: User) = {
    Math.hypot(user1.location._1 - user2.location._1, user1.location._2 - user2.location._2)
  }

}

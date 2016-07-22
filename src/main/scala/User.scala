/**
  * Created by goncalocastro on 22/07/2016.
  */
case class User(name: String, location: (Int, Int)) {
  def shout(message: String, network: Network) = {
    network.users
      .filter(u => u != this)
      .filter(u => network.calculateDistance(this, u) <= network.MAX_SHOUT_DISTANCE)
  }
}



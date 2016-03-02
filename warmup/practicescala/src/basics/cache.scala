package basics

import traits.Cache
//just checking casing and if it conflicts
object cache extends Cache[Integer, String] {

    var notfound = "NOT FOUND";
    private var map = scala.collection.mutable.Map[Integer, String]();
  
    def put(key:Integer, value:String){
      map += (key -> value);
    }

    //I assume in practice that getOrElse is intended to be delayed until the last second when it's needed
    //Which means Option[String] should be part of my trait and passed out of here in practice I think
    //but I'm just learning right now
    def get(key:Integer): String = {
      map.get(key).getOrElse(notfound);
    }
    
    def delete(key:Integer){
      map -= key;
    }
    
    def reset(){
      map.clear();
    }
}
package com.graphsaga.wiki.repo.input

case class TitleInput (serial:Int, branch:Int, title:String){
  def show = {
    println(s"シリアル番号:枝番号 = $serial:$branch")
    println(s"　　　 　　タイトル = $title")
  }
}



package macroid.viewable

import android.view.View
import android.widget.AdapterView
import macroid.Tweaking._
import macroid.Tweaks._
import macroid.{ActivityContext, AppContext, Tweak}

object ViewableTweaks {
  def adapter[A](itemViewable: FillableViewable[A])(data: Seq[A])(implicit ctx: ActivityContext, appCtx: AppContext) =
    Tweak[AdapterView[_ >: FillableViewableAdapter[A]]](_.setAdapter(FillableViewableAdapter.apply(data)(itemViewable)))

  def bind[W <: View, A](tweak: A => Tweak[W])(implicit binding: Binding[A]) = {
    val slot = new Slot[W]
    def binder(data: A) = slot.view <~ tweak(data)
    binding.binders ::= binder
    wire(slot.view)
  }
  
  class Slot[W <: View](var view: Option[W] = None)
}

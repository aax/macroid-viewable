package macroid.viewable

import android.widget.AdapterView
import macroid.{ActivityContext, AppContext, Tweak}

object ViewableTweaks {
  def adapter[A](itemViewable: FillableViewable[A])(data: Seq[A])(implicit ctx: ActivityContext, appCtx: AppContext) =
    Tweak[AdapterView[_ >: FillableViewableAdapter[A]]](_.setAdapter(FillableViewableAdapter.apply(data)(itemViewable)))
}

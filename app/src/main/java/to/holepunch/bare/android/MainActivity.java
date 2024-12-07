package to.holepunch.bare.android;

import android.app.Activity;
import android.os.Bundle;
import to.holepunch.bare.kit.Worklet;

public class MainActivity extends Activity {
  Worklet worklet;

  @Override
  public void
  onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    worklet = new Worklet(null);

    try {
      worklet.start("/app.bundle", getAssets().open("app.bundle"), null);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void
  onPause() {
    super.onPause();

    worklet.suspend();
  }

  @Override
  public void
  onResume() {
    super.onResume();

    worklet.resume();
  }

  @Override
  public void
  onDestroy() {
    super.onDestroy();

    worklet.terminate();
    worklet = null;
  }
}

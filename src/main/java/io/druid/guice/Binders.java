package io.druid.guice;

import com.google.inject.Binder;
import com.google.inject.Key;
import com.google.inject.multibindings.MapBinder;
import io.druid.segment.loading.DataSegmentArchiver;
import io.druid.segment.loading.DataSegmentMover;
import io.druid.segment.loading.DataSegmentKiller;
import io.druid.segment.loading.DataSegmentPuller;
import io.druid.segment.loading.DataSegmentPusher;
import io.druid.tasklogs.TaskLogs;

/**
 */
public class Binders
{
  public static MapBinder<String, DataSegmentPuller> dataSegmentPullerBinder(Binder binder)
  {
    return MapBinder.newMapBinder(binder, String.class, DataSegmentPuller.class);
  }

  public static MapBinder<String, DataSegmentKiller> dataSegmentKillerBinder(Binder binder)
  {
    return MapBinder.newMapBinder(binder, String.class, DataSegmentKiller.class);
  }

  public static MapBinder<String, DataSegmentMover> dataSegmentMoverBinder(Binder binder)
  {
    return MapBinder.newMapBinder(binder, String.class, DataSegmentMover.class);
  }

  public static MapBinder<String, DataSegmentArchiver> dataSegmentArchiverBinder(Binder binder)
  {
    return MapBinder.newMapBinder(binder, String.class, DataSegmentArchiver.class);
  }

  public static MapBinder<String, DataSegmentPusher> dataSegmentPusherBinder(Binder binder)
  {
    return PolyBind.optionBinder(binder, Key.get(DataSegmentPusher.class));
  }

  public static MapBinder<String, TaskLogs> taskLogsBinder(Binder binder)
  {
    return PolyBind.optionBinder(binder, Key.get(TaskLogs.class));
  }
}

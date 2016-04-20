package mattski47.databases386;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewExerciseActivity extends AppCompatActivity implements View.OnClickListener
{
    private Intent addIntent;
    private DBHandler saveData;
    private long count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_exercise);
        saveData = saveData.getInstance(this);

        Button add = (Button) findViewById(R.id.add);

        TableLayout table = (TableLayout)this.findViewById(R.id.table);
        ArrayList<Exercise> all = saveData.getExerciseInfo();

        count = saveData.countExercise();

        for(int i=0; i<count; i++) {
            TableRow row = (TableRow) LayoutInflater.from(this).inflate(R.layout.exercise_format, null);
            ((TextView)row.findViewById(R.id.activity)).setText(all.get(i).getActivity());
            ((TextView)row.findViewById(R.id.date)).setText(all.get(i).getDate());
            ((TextView)row.findViewById(R.id.time)).setText("" + all.get(i).getTime() + " hrs");
            table.addView(row);
        }
        table.requestLayout();

        this.addIntent = new Intent(this, AddExerciseActivity.class);

        add.setOnClickListener(this);
    }


    public void onClick(View v)
    {
        startActivity(this.addIntent);
    }

}

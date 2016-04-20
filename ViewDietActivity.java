package mattski47.databases386;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewDietActivity extends AppCompatActivity implements View.OnClickListener
{
    private Intent addIntent;
    private DBHandler saveData;
    private long count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_diet);
        saveData = saveData.getInstance(this);

        Button add = (Button) findViewById(R.id.add);

        TableLayout table = (TableLayout)this.findViewById(R.id.table);
        ArrayList<Diet> all = saveData.getDietInfo();

        count = saveData.countDiet();

        for(int i=0; i<count; i++) {
            TableRow row = (TableRow)LayoutInflater.from(this).inflate(R.layout.diet_format, null);
            ((TextView)row.findViewById(R.id.food)).setText(all.get(i).getFood());
            ((TextView)row.findViewById(R.id.date)).setText(all.get(i).getDate());
            ((TextView)row.findViewById(R.id.calories)).setText("" + all.get(i).getCalories());
            table.addView(row);
        }
        table.requestLayout();

        this.addIntent = new Intent(this, AddDietActivity.class);

        add.setOnClickListener(this);
    }


    public void onClick(View v)
    {
        startActivity(this.addIntent);
    }

}

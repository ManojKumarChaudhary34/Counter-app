package com.example.counter;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import com.example.counter.databinding.ActivityCounterBinding;

public class CounterActivity extends AppCompatActivity {

    ActivityCounterBinding binding;
    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCounterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String email = getIntent().getExtras().getString("email");
        binding.email.setText(email);

        counter = 0;
        setUpClickable();
        binding.increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                setUpClickable();
                binding.counterTxt.setText("" + counter);

            }
        });
        binding.decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter--;
                setUpClickable();
                binding.counterTxt.setText("" + counter);

            }
        });

    }

    private void setUpClickable() {
        if (counter == 0) {
            binding.decrement.setClickable(false);
            binding.decrement.setEnabled(false);
            binding.decrement.setColorFilter(getColor(R.color.text_clr));
            binding.counterTxt.setTextColor(getColor(R.color.white));
            binding.mainCardView.setBackground( AppCompatResources.getDrawable(CounterActivity.this,R.drawable.main_card_bg1));
            binding.decrement.setBackground( AppCompatResources.getDrawable(CounterActivity.this,R.drawable.disabled_bg));

            binding.increment.setBackground( AppCompatResources.getDrawable(CounterActivity.this,R.drawable.enabled_bg));
        } else {
            binding.decrement.setClickable(true);
            binding.decrement.setEnabled(true);
            binding.decrement.setColorFilter(getColor(R.color.black));
            binding.counterTxt.setTextColor(getColor(R.color.black));

            binding.mainCardView.setBackground( AppCompatResources.getDrawable(CounterActivity.this,R.drawable.main_card_bg2));
            binding.decrement.setBackground( AppCompatResources.getDrawable(CounterActivity.this,R.drawable.enabled_bg));

            binding.increment.setBackground( AppCompatResources.getDrawable(CounterActivity.this,R.drawable.enabled_bg));

        }
    }
}
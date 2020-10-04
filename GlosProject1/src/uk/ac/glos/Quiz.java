package uk.ac.glos;

/**
 * This is the activity class is for the quiz screen.
 * @author      Ambikesh Jayal, Department of Computing, University of Gloucestershire
 * @version     1.0, 15 September 2010
 */

import uk.ac.glos.R;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Quiz extends Activity {

	private int marks = 0;

	public void onResume() {
		super.onResume();
		marks = 0;
	}

	protected void onStart() {
		super.onStart();

		setContentView(R.layout.main);

		marks = 0;

		final Button submitquiz = (Button) findViewById(R.id.submitquiz);
		submitquiz.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {

				String buttontext = submitquiz.getText().toString();
				if (buttontext.equalsIgnoreCase("Try Again")) {
					//reset everything
					TextView tv = (TextView) findViewById(R.id.marksview);
					tv.setText("");
					
					ImageView iv1 = (ImageView) findViewById(R.id.winimage1);
					iv1.setImageResource(-1);
					
					
					TextView tvQuizstartdesc = (TextView) findViewById(R.id.quizstartdesc);
					tvQuizstartdesc.setText("Please select the correct answers for following FOUR questions and click the submit quiz button.");
					
					TextView tv1 = (TextView) findViewById(R.id.correctanswer);
					tv1.setText("");
					
					submitquiz.setText("Submit Quiz");
					
				
					
				} else {

					RadioButton rb1 = (RadioButton) findViewById(R.id.option1a);
					if (rb1.isChecked()) {
						marks = marks + 1;
					}

					RadioButton rb2 = (RadioButton) findViewById(R.id.option2b);
					if (rb2.isChecked()) {
						marks = marks + 1;
					}

					RadioButton rb3 = (RadioButton) findViewById(R.id.option3b);
					if (rb3.isChecked()) {
						marks = marks + 1;
					}

					RadioButton rb4 = (RadioButton) findViewById(R.id.option4d);
					if (rb4.isChecked()) {
						marks = marks + 1;
					}

					TextView tv = (TextView) findViewById(R.id.marksview);
					if (marks == 4) {
						tv.setText("Excellent! You answered all questions correctly. Here is your prize");
						ImageView iv1 = (ImageView) findViewById(R.id.winimage1);
						iv1.setImageResource(R.drawable.winprize1);
						
						iv1.setAdjustViewBounds(true);
						iv1.setMaxHeight(100);
					
					} else if (marks == 3) {
						tv.setText("Well done! You answered all but one questions correctly. Here is your prize");
						ImageView iv1 = (ImageView) findViewById(R.id.winimage1);
						iv1.setImageResource(R.drawable.winprize2);
						iv1.setAdjustViewBounds(true);
						iv1.setMaxHeight(100);
					} else if (marks == 2) {
						tv.setText("Good try! You answered all but two questions correctly. Here is your prize");
						ImageView iv1 = (ImageView) findViewById(R.id.winimage1);
						iv1.setImageResource(R.drawable.winprize3);
						iv1.setAdjustViewBounds(true);
						iv1.setMaxHeight(100);
					} else if (marks == 1) {
						tv.setText("You need to improve! You answered just one question correctly. "
								+ "Here is your consolation prize for trying the quiz.");
						ImageView iv1 = (ImageView) findViewById(R.id.winimage1);
						iv1.setImageResource(R.drawable.winprize4);
						iv1.setAdjustViewBounds(true);
						iv1.setMaxHeight(100);
					} else if (marks <= 0) {
						tv.setText("You answered none of the questions correctly. You need to improve."
								+ "Sorry but no prize for you. Try again.");
						
					}

					if (marks >= 1){
					TextView tv1 = (TextView) findViewById(R.id.correctanswer);
					tv1.setText("\nCorrect answers are Q1: a, Q2: b, Q3: b, Q4: d");
					}

					TextView tvQuizstartdesc = (TextView) findViewById(R.id.quizstartdesc);
					tvQuizstartdesc.setText("");
					
					
					submitquiz.setText("Try Again");

					marks = 0;

				}
			}

		});

	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}
}
package com.mirea.denisignatenko.mireaproject.ui.calculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.mirea.denisignatenko.mireaproject.R;

import java.util.ArrayList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class CalculatorFragment extends Fragment {
    TextView workingsTV;
    TextView resultsTV;

    String workings = "";
    String formula = "";
    String tempFormula = "";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_calculator, container, false);
        workingsTV = root.findViewById(R.id.workings_text);
        resultsTV = root.findViewById(R.id.result_text);

        root.findViewById(R.id.button_brackets).setOnClickListener(bracketsOnClick);
        root.findViewById(R.id.button_one).setOnClickListener(oneOnClick);
        root.findViewById(R.id.button_two).setOnClickListener(twoOnClick);
        root.findViewById(R.id.button_three).setOnClickListener(threeOnClick);
        root.findViewById(R.id.button_four).setOnClickListener(fourOnClick);
        root.findViewById(R.id.button_five).setOnClickListener(fiveOnClick);
        root.findViewById(R.id.button_six).setOnClickListener(sixOnClick);
        root.findViewById(R.id.button_seven).setOnClickListener(sevenOnClick);
        root.findViewById(R.id.button_eight).setOnClickListener(eightOnClick);
        root.findViewById(R.id.button_nine).setOnClickListener(nineOnClick);
        root.findViewById(R.id.button_decimal).setOnClickListener(decimalOnClick);
        root.findViewById(R.id.button_zero).setOnClickListener(zeroOnClick);
        root.findViewById(R.id.button_equals).setOnClickListener(equalsOnClick);
        root.findViewById(R.id.button_plus).setOnClickListener(plusOnClick);
        root.findViewById(R.id.button_minus).setOnClickListener(minusOnClick);
        root.findViewById(R.id.button_times).setOnClickListener(timesOnClick);
        root.findViewById(R.id.button_div).setOnClickListener(divisionOnClick);
        root.findViewById(R.id.button_power).setOnClickListener(powerOfOnClick);
        root.findViewById(R.id.button_clear).setOnClickListener(clearOnClick);

        return root;
    }

    private void setWorkings(String givenValue) {
        workings = workings + givenValue;
        workingsTV.setText(workings);
    }

    private void checkForPowerOf() {
        ArrayList<Integer> indexOfPowers = new ArrayList<>();
        for (int i = 0; i < workings.length(); i++) {
            if (workings.charAt(i) == '^')
                indexOfPowers.add(i);
        }

        formula = workings;
        tempFormula = workings;
        for (Integer index : indexOfPowers) {
            changeFormula(index);
        }
        formula = tempFormula;
    }

    private void changeFormula(Integer index) {
        String numberLeft = "";
        String numberRight = "";

        for (int i = index + 1; i < workings.length(); i++) {
            if (isNumeric(workings.charAt(i)))
                numberRight = numberRight + workings.charAt(i);
            else
                break;
        }

        for (int i = index - 1; i >= 0; i--) {
            if (isNumeric(workings.charAt(i)))
                numberLeft = numberLeft + workings.charAt(i);
            else
                break;
        }

        String original = numberLeft + "^" + numberRight;
        String changed = "Math.pow(" + numberLeft + "," + numberRight + ")";
        tempFormula = tempFormula.replace(original, changed);
    }

    private boolean isNumeric(char c) {
        if ((c <= '9' && c >= '0') || c == '.')
            return true;

        return false;
    }

    boolean leftBracket = true;

    View.OnClickListener zeroOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setWorkings("0");
        }
    };

    View.OnClickListener decimalOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setWorkings(".");
        }
    };

    View.OnClickListener plusOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setWorkings("+");
        }
    };

    View.OnClickListener threeOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setWorkings("3");
        }
    };

    View.OnClickListener twoOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setWorkings("2");
        }
    };

    View.OnClickListener oneOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setWorkings("1");
        }
    };

    View.OnClickListener minusOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setWorkings("-");
        }
    };

    View.OnClickListener sixOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setWorkings("6");
        }
    };

    View.OnClickListener fiveOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setWorkings("5");
        }
    };

    View.OnClickListener fourOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setWorkings("4");
        }
    };

    View.OnClickListener timesOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setWorkings("*");
        }
    };

    View.OnClickListener nineOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setWorkings("9");
        }
    };

    View.OnClickListener eightOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setWorkings("8");
        }
    };

    View.OnClickListener sevenOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setWorkings("7");
        }
    };

    View.OnClickListener divisionOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setWorkings("/");
        }
    };

    View.OnClickListener powerOfOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setWorkings("^");
        }
    };

    View.OnClickListener bracketsOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (leftBracket) {
                setWorkings("(");
                leftBracket = false;
            } else {
                setWorkings(")");
                leftBracket = true;
            }
        }
    };

    View.OnClickListener clearOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            workingsTV.setText("");
            workings = "";
            resultsTV.setText("");
            leftBracket = true;
        }
    };

    View.OnClickListener equalsOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Double result = null;
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
            checkForPowerOf();

            try {
                result = (double) engine.eval(formula);
            } catch (ScriptException e) {
                Toast.makeText(getActivity(), "Invalid Input", Toast.LENGTH_SHORT).show();
            }

            if (result != null)
                resultsTV.setText(String.valueOf(result.doubleValue()));

        }
    };
}
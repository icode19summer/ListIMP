import com.sun.scenario.animation.shared.ClipEnvelope;

import java.util.Arrays;

public class Polynomial {
    ArrayList<Double> coefficient=new ArrayList<>();
    ArrayList<Double> index=new ArrayList<>();
    private int n;
    public Polynomial(){}
    public Polynomial(double[] a,double[] b) throws Exception{

        int max;
        for(int i=0;i<a.length-1;i++) {
            max=i;
            for (int j = i + 1; j < a.length; j++) {
                if (b[j] >b[max])
                    max = j;
            }
            if(max==i)
                continue;
            double temp=b[i];
            b[i]=b[max];
            b[max]=temp;
            temp=a[i];
            a[i]=a[max];
            a[max]=temp;
        }
        coefficient.add(a[0]);
        index.add(b[0]);
        int i=1;
        int count=0;
        while(i<a.length) {
            if(b[i]!=b[i-1]){
                coefficient.add(a[i]);
                index.add(b[i]);
            }else{
                coefficient.set(i-1,a[i]+a[i-1]);
                count++;
            }
            i++;
        }
        n=a.length-count;
    }
    public void display() throws Exception{
        sort();
        for(int i=0;i<n;i++) {
            if(index.get(i)==0){
                System.out.print(show(coefficient.get(i)));
                if(i!=n-1)
                    System.out.print(" + ");
                continue;
            }
            if(Math.abs(coefficient.get(i))!=1){
                System.out.print(show(coefficient.get(i)));
            }else if(coefficient.get(i)==-1)
                System.out.print("-");
            System.out.print("x");
            if(index.get(i)==1){
                if(i!=n-1)
                   System.out.print(" + ");
                continue;
            }
            System.out.print("^"+show(index.get(i)));
            if(i!=n-1)
                System.out.print(" + ");
        }
    }
    public void add(Polynomial p) throws Exception{
        int i=0,j=0,c=n;
        while(i<c&&j<p.n){
            if(index.get(i).compareTo(p.index.get(j))==0){
                coefficient.set(i,coefficient.get(i)+p.coefficient.get(j));
                if(coefficient.get(i)==0){
                    coefficient.remove(i);
                    index.remove(i);
                    n--;
                    j++;
                    continue;
                }
                i++;
                j++;
            }else if(index.get(i).compareTo(p.index.get(j))<0){
                coefficient.add(p.coefficient.get(j));
                index.add(p.index.get(j));
                j++;
                n++;
            }else{
                i++;
            }
        }

        if(i==c){
            while(j<p.n){
                if(p.coefficient.get(j)==0){
                    j++;
                    continue;
                }

                coefficient.add(p.coefficient.get(j));
                index.add(p.index.get(j));
                n++;
                j++;
            }
        }
    }
    public void submit(Polynomial p) throws Exception{
        for(int i=0;i<p.n;i++){
            p.coefficient.set(i,p.coefficient.get(i)*-1);
        }
        add(p);
    }
    public void d() throws Exception{
        int i=0;
        while(i<n){
            if(index.get(i)==0){
                coefficient.remove(i);
                n--;
                i++;
                continue;
            }
            coefficient.set(i,coefficient.get(i)*index.get(i));
            index.set(i,index.get(i)-1);
            i++;
        }
    }
    private String show(double x) throws Exception{
        if(Math.round(x)-x==0)
            return String.valueOf((int)x);
        return String.valueOf(x);
    }
    private void sort() throws Exception{
        int max;
        for(int i=0;i<n-1;i++) {
            max=i;
            for (int j = i + 1; j < n; j++) {
                if (index.get(j ) > index.get(max))
                    max = j;
            }
            if(max==i)
                continue;
            double temp=index.get(i);
            index.set(i,index.get(max));
            index.set(max,temp);
            temp=coefficient.get(i);
            coefficient.set(i,coefficient.get(max));
            coefficient.set(max,temp);
        }
    }
}

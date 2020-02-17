package StacksAndQueues;

import java.util.ArrayList;
import java.util.List;

public class StackOfPlates {

	public int stack_size;
	public int arr_num=0;
	public int curr_pop_ind=0;
	List<List<Integer>> stack_of_stacks = null;
	//List<Integer> current_list = null;
	List<Integer> temp_list = null;
	
	public StackOfPlates() {
	}
	
	public StackOfPlates(int stack_size) {
		this.stack_size = stack_size;
	}
	
	public void push(int val) {
		List<Integer> current_list = null;
		if(stack_of_stacks==null)
		{
			stack_of_stacks = new ArrayList<List<Integer>>();
			current_list = new ArrayList<Integer>();
			stack_of_stacks.add(current_list);
		}
		
		if(stack_of_stacks.get(arr_num).size()==stack_size){
			current_list = new ArrayList<Integer>();
			current_list.add(val);
			stack_of_stacks.add(current_list);
			curr_pop_ind = 0;
			arr_num=arr_num+1;
			return;
		}
		
		if(stack_of_stacks.get(arr_num).size()<stack_size) {
			stack_of_stacks.get(arr_num).add(val);
			curr_pop_ind = curr_pop_ind+1;
		}
	}
	
	public int pop() {
		if(stack_of_stacks==null)
		{
			return -1;
		}
		
		int return_val = -1;
		int no_of_stacks = stack_of_stacks.size()-1;
		if(no_of_stacks>=0) {
			int last_stack_size = stack_of_stacks.get(no_of_stacks).size()-1;
			return_val = stack_of_stacks.get(no_of_stacks).get(last_stack_size);
			stack_of_stacks.get(no_of_stacks).remove(last_stack_size);
		}
		
		if(stack_of_stacks.get(no_of_stacks).isEmpty()) {
			stack_of_stacks.remove(no_of_stacks);
		}
		return return_val;
	}
	
	/*public int pop() {
		if(stack_of_stacks==null)
		{
			return -1;
		}
		
		int return_val = -1;
		
		if(stack_of_stacks.get(arr_num).isEmpty() && arr_num>=0) {
			stack_of_stacks.remove(arr_num);
			arr_num = arr_num-1;
			curr_pop_ind = stack_of_stacks.get(arr_num).size()-1;
			return_val = stack_of_stacks.get(arr_num).get(curr_pop_ind);
			stack_of_stacks.get(arr_num).remove(curr_pop_ind);
			curr_pop_ind = curr_pop_ind-1;
		}else if(!stack_of_stacks.get(arr_num).isEmpty() && arr_num>=0){
			return_val = stack_of_stacks.get(arr_num).get(curr_pop_ind);
			stack_of_stacks.get(arr_num).remove(curr_pop_ind);
			curr_pop_ind = curr_pop_ind-1;
		}
		return return_val;
	}*/
	
	public int popAt(int index) {
		int return_val=-1;
		if(!stack_of_stacks.get(index).isEmpty() && index>=0) {
			int temp_curr_pop_ind = stack_of_stacks.get(index).size()-1;
			return_val = stack_of_stacks.get(index).get(temp_curr_pop_ind);
			stack_of_stacks.get(index).remove(temp_curr_pop_ind);
		}
		
		if(stack_of_stacks.get(index).isEmpty()) {
			stack_of_stacks.remove(index);
		}
		return return_val;	
	}
	
	public static void main(String...args) {
		StackOfPlates sop = new StackOfPlates(2);
		sop.push(1);
		sop.push(2);
		sop.push(3);
		sop.push(4);
		sop.push(5);
		System.out.println(sop.stack_of_stacks);
		System.out.println("popAt 1:"+sop.popAt(1));
		System.out.println(sop.stack_of_stacks);
		System.out.println("popAt 1:"+sop.popAt(1));
		System.out.println("pop:"+sop.pop());
		System.out.println("popAt 0:"+sop.popAt(0));
		System.out.println(sop.stack_of_stacks);
		System.out.println("pop:"+sop.pop());
		System.out.println("pop:"+sop.pop());
		System.out.println("pop:"+sop.pop());
		//System.out.println("pop:"+sop.pop());
	}
}

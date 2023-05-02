#include <linux/init.h>
#include <linux/module.h>
#include <linux/kernel.h>
#include <linux/list.h>
#include <linux/slab.h>

struct birthday
{    
    int month;
    int day;
    int year;
	char *name;
	struct list_head list;
};

/**
 * The following defines and initializes a list_head object named birthday_list
 */
static LIST_HEAD(birthday_list);

int part3_init(void)
{
    
    
	printk(KERN_INFO "***Loading Proejct1 Part3 Module***\n");

	/* Create a linked list containing five struct birthday elements*/
    
	/* NOTE:THE NAME OF FIRST STRUCT BIRTHDAY SHOULD BE YOUR OWN NAME */
   


        
        
	/* Traverse the linked list  */
    
	//Add codes here......
struct birthday *member;
member = kmalloc(sizeof(*member), GFP_KERNEL);
        member->month = 9;
        member->day = 5;
        member->year = 2002;
        member->name = "Ayman";
        list_add_tail(&member->list, &birthday_list);
member->month = 9;
        member->day = 5;
        member->year = 2002;
        member->name = "Billy";
        list_add_tail(&member->list, &birthday_list);
member->month = 9;
        member->day = 5;
        member->year = 2002;
        member->name = "Steve";
        list_add_tail(&member->list, &birthday_list);
    struct birthday *ptr;
    list_for_each_entry(ptr, &birthday_list, list)
    {
        printk(KERN_INFO "Name: %s, Date of Birth: %d/%d/%d\n", ptr->name, ptr->month, ptr->day, ptr->year);
    }
    
	return 0;
}

void part3_exit(void) {
    
    
	printk(KERN_INFO "***Removing Project1 Part3 Module***\n");

	/* Remove the elements from the linked list and return the free memory back to the kernel */
    
	//////////Add your codes here....
struct birthday *ptr, *next;
    printk(KERN_INFO "Unloading  Name: %s, Date of Birth: %d/%d/%d\n", ptr->name, ptr->month, ptr->day, ptr->year);
    list_for_each_entry_safe(ptr, next, &birthday_list, list)
    {
        list_del(&ptr->list);
        kfree(ptr);
    }
}

module_init( part3_init );
module_exit( part3_exit );

MODULE_LICENSE("GPL");
MODULE_DESCRIPTION("Proejct1 Part3");
MODULE_AUTHOR("GSU_CSC4320_6320_TH_Spring2023");





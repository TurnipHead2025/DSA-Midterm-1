

# Why was a Queue appropriate for the waiting room?
Because patients are seen in a first come, first serve basis ordinarially. The queue keeps the patient order. It also allows for an emergency patient to be inserted into positon 1.

# Explain FIFO principle
FIFO means First In First Out. Queued entries are processed in the same order they were added. 

# Explain what could happen if a stack was used instead of a queue in Part 1.
A stack operates under the LIFO pronciple. Last In First Out. In this system it would have servered the last patient first.

# Suggest ways that you could improve this system (Theory)
I would link each history recors to a patientId, so it could show the right history of the patient.
Also the ability to remove patients

# Why is a Doubly Linked List appropriate for patient history?
So the user could navigate backwards through olde visits and forward to newer ones.This would allow the user to find records more easily and improve patient care.

# What would happen in the DLL if you forgot to update the next and previous pointers when manipulating the DLL?
the history may no longer navigate correctly. Visits could be skipped or lost

# Explain why a Doubly Linked List Works in this case compared to an Array or Array List.
An array is a fixed size and would be inefficient for adding patient history or to the waiting room. It would require alot of compute to rebuild lists and just be awkward.

 An arrayList could work. But insertions and deletions are slow. Will waste memory if you don't use the whole array size. Middle insertions may shift elements and resizing requires copying into a larger array.  
 
 A DLL is appropriate because the user can naviagte forward and back, add patients, without a complicated hot mess.  

# Tests
*1* servingEmptyWaitingRoomReturnsNull()
This test checks that null is returned if the queue is empty when serving the next patient

*2* waitingRoomServesPatientsInArrivalOrder()
Tests the FIFO. That the patients are served in the same order they were added.

*3* emergencyPatientIsInsertedAtRequestedPosition()
It checks that an emergency patient is inserted at the requested position and that patients are served in the new order. 

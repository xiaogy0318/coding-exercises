import heapq;
import copy;

heap = [3, 1, 5, 7, 4];
heapq.heapify(heap);
heapmax = copy.copy(heap);
heapq._heapify_max(heapmax);

print(heap);
print(heapmax);

min = heapq.heappop(heap); 
#heapq.heapify(heap);
max = heapq.heappop(heapmax); 

# Caveat: must max heapify again, otherwise it doesn't work
heapq._heapify_max(heapmax);
print (min);
print (max);

while(min < max):
	min = heapq.heappop(heap); 
	#heapq.heapify(heap);
	max = heapq.heappop(heapmax); 
	heapq._heapify_max(heapmax);
	
	print (min);
	print (max);
print((min + max) / 2);
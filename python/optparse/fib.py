import optparse

def fib(n, prin):
	a, b = 0, 1
	for i in range(n):
		a, b = b, a + b
		if prin:
			print a
	return a
	
def Main():
	parser = optparse.OptionParser('usage %prog ' + \
		'-n <fib number> -o <output file> -a <print all>', version = '%prog 1.0')
	parser.add_option('-n', dest = 'num', type = 'int', \
		help = 'specify the n''th fibonacci number to output')
	parser.add_option('-o', dest = 'out', type = 'string', \
		help = 'specify an output file optionally')
	parser.add_option('-a', '--all', action = 'store_true', dest = 'prin', \
		default = False, help = 'print all numbers to n'
		
	#(options, args) = parser.parse_args()
	options, args = parser.parse_args()
	if(option.num == None):
		print parser.usage
		exit(0)
	else:
		number = option.num
		
	result = fib(number, option.prin)
	print 'The ' + str(number) + 'th fib number is: ' + str(result)
	
	if(option.out != None):
		f = open(option.out, 'a')
		f.write(str(result)) + '\n'
		
if (__name__ == '__main__'):
	Main()
	
	
	
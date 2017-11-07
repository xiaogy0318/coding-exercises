#!/usr/local/perl

if (! open MYFILE, "./a.txt") {
	die "File not existing";
}
print "fred\n";

while (<MYFILE>) {
	chomp;
	if (/[F|f]red/) {
		print "$_\n";
	}
}

print ".\n";

if (! open MYFILE, "./a.txt") {
	die "File not existing";
}

while (<MYFILE>) {
	chomp;
	if (/.*\..*/) {
		print "$_\n";
	}	
	
}

print "non-white space two of them\n";

if (! open MYFILE, "./a.txt") {
	die "File not existing";
}

while (<MYFILE>) {
	chomp;
	if (/([\D])\1/) {
		print "$_\n";
	}	
	
}

print "both david and richard";

if (! open MYFILE, "./a.txt") {
	die "File not existing";
}

while (<MYFILE>) {
	chomp;
	if (/david.*richard|richard.*david/) {
		print "$_\n";
	}	
	
}
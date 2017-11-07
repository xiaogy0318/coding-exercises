#!/usr/local/perl

#print reverse <>;

print "12345678901234567890123456789012345678901234567890\n";
$mystring = "goodbye";
printf "%20s\n", $mystring;

$line = <STDIN>;
chomp($line);
while (<STDIN>) {
	chomp;
	print "1234567890" x $line . "\n";
	printf "%${line}s\n", $_;
}

